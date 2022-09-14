package hello.core.Singleton;

public class SingletoneService {

    private static final SingletoneService instance = new SingletoneService();

    public static SingletoneService getInstance(){
        return instance;
    }
    private SingletoneService(){
    }

    public void logic(){
        System.out.println("싱글통 로직 실행");
    }
}
