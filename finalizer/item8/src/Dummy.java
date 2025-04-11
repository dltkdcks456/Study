public class Dummy {
    // 자원 초기화 예시
    private String resource;

    public Dummy(final String resource) {
        this.resource = resource;
        System.out.println("Dummy 객체 생성");
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            // 객체가 GC에 의해 수집될 때 자원을 정리하는 코드
            System.out.println("GC에 의해 수집됩니다. 자원 정리 중...");
            resource = null;
        } finally {
            super.finalize();
        }
    }
}
