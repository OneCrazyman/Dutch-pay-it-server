package gdsc.toypj.dutchpayit.repository;

import gdsc.toypj.dutchpayit.domain.Menu;
import gdsc.toypj.dutchpayit.domain.People;
import gdsc.toypj.dutchpayit.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    //저장
    public void save(Menu menu){
        em.persist(menu);
    }

    //메뉴 찾기
    public Menu findOne(Long id){
        return em.find(Menu.class,id);
    }

    //삭제
    public void delete(Menu menu){
        em.remove(menu);
    }

    //모든 메뉴 찾기
    public List<Menu> findAll(){
        return em.createQuery("select r from Menu r", Menu.class)
                .getResultList();
    }

    public List<Menu> createdByMe(Long userId){
        return em.createQuery("select r from Menu r" +
                        " join fetch r.user m where m.id =: userId", Menu.class)
                .setParameter("userId",userId).getResultList();
    }

    public void sendImageToPython(MultipartFile imgFile) throws IOException {
        byte[] bytes = imgFile.getBytes();
//         ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//         byte[] bytes = byteArray.toByteArray();
        //파일불러와서 바이트화
//        File fi = new File("C:/img.jpg");
//        byte[] bytes = Files.readAllBytes(fi.toPath());

        Integer len = bytes.length;
        String lenStr = Integer.toString(len);

        //바이트 사이즈를 16바이트화
        // byte[] byte16 = IntToBytes(bytes.length);
        // System.out.println(byte16);
        try{
            Socket socket = new Socket("127.0.0.1", 9999);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            //이미지 파일 사이즈를 16바이트화한 데이터 전송
            //utf-8로 인코딩
            //이미지파일 전송
            dos.write(bytes);
            dos.flush();
            System.out.println("success: byte");

            socket.close();
            System.out.println("socket closed");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //ML에서 업로드한 Menu list로 뽑기
    //key_name, shop으로 조건 검색
    public List<Menu> findByUserAndShop(Long user,String shop)
    {
        return em.createQuery("select m from Menu m where m.user.id = :user and m.shop = :shop", Menu.class)
                .setParameter("user", user)
                .setParameter("shop", shop)
                .getResultList();
    }
}
