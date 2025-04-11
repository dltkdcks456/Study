import java.io.Closeable;

public class NativeResource {
    private long nativeHandle;

    // 네이티브 메서드 - 실제 네이티브 라이브러리에서 리소스를 할당
    public native long allocateNativeResource();

    // 네이티브 메서드 - 실제 네이티브 라이브러리에서 리소스를 해제
    public native void releaseNativeResource(long handle);

    public NativeResource(final long nativeHandle) {
        this.nativeHandle = nativeHandle;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (nativeHandle != 0) {
                System.out.println("finalize() 호출: 네이티브 리소스를 해제합니다.");
                releaseNativeResource(nativeHandle);
            }
        } finally {
            super.finalize();
        }
    }
}
