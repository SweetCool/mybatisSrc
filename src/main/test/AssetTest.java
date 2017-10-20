
import debug.dao.Assetdebug;
import debug.model.Asset;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AssetTest {

    public static void main(String[] args) {
        findAssetById();
    }


    @Test
    public static void findAssetById() {

        SqlSession sqlSession = getSessionFactory().openSession();
        Assetdebug mapper = sqlSession.getMapper(Assetdebug.class);
        Map<String,Object> map = new HashMap<>();
        map.put("asset_id",21);
        Asset asset = mapper.getById(map);
        System.out.println(asset.getItemNo());

    }

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "mybatis.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
