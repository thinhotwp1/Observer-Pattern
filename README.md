Link drive:  https://docs.google.com/document/d/1S-JXrjglPbQ7pDbBFYs3d6Malo_ULCgNc_ZG7u9sIVY/edit?usp=sharing

1. ObserverPatternSample ( Tự thiết kế ra mẫu Observer Partern của riêng mình )
2. ObserverPatternSampleUseJAVA.UTIL.OBSERVABLE ( Thiết kế mẫu Observer Partern dựa theo thư viện JAVA.UTIL.OBSERVABLE: sử dụng setChanged để tăng độ linh hoạt khi nào nhận tin từ người nhà sản xuất của từng người đăng kí )

Một nhà sản xuất có thể có nhiều người đăng kí nhận bài báo mới nhất, nhà sản xuất là Subject (hay Obsevible) và những người đăng kí gọi là Observer. Khi cập nhật hay có thông báo nhà sx sẽ gửi tới tất cả những người đăng kí.

Observer Pattern: Sức mạnh của khớp nối lỏng lẻo (Loose Coupling)
Khi hai đối tượng được ghép lỏng lẻo, chúng có thể tương tác, nhưng chúng biết rất ít về nhau.
Observer pattern cung cấp một thiết kế đối tượng trong đó subjects và observers được ghép lỏng lẻo với nhau.
Tại sao ư?
Điều duy nhất mà Subject biết về một người quan sát (observer) là nó implement một interface nhất định (interface Observer). Nó không cần phải biết lớp con cụ thể của Observer, những gì nó làm, hoặc bất cứ điều gì khác về nó.

Thay đổi Subject hoặc Observer sẽ không ảnh hưởng đến đối tượng còn lại.
Do cả hai được ghép lỏng lẻo, chúng có thể tự do thay đổi, miễn là các đối tượng vẫn đáp ứng được trách nhiệm của chúng để implements interface Subject hoặc Observer.

Có một vấn đề: Khi 1 observer không muốn nhận dữ liệu update liên tục mà chỉ muốn nhận dữ liệu khi nhiệt độ thay đổi từ 1 độ C trở lên thì sao, khi đó ta có thể dùng thêm setChanged để cho observer có thể chủ động nhận thông báo có sự thay đổi từ Object thay vì bị động như trên
Phương thức setChanged() được sử dụng để biểu thị rằng trạng thái đã thay đổi và khi đó notifyObservers(), khi được gọi, nên cập nhật trình observers của nó. Nếu notifyObservers() được gọi mà không gọi setChanged() trước, người quan sát (observer) sẽ KHÔNG được thông báo. Hãy cùng nhìn vào “behind the scenes” của Observable để xem cách thức hoạt động của nó:

Tóm tắt:
Observer Pattern xác định mối quan hệ một-nhiều giữa các đối tượng.
Subjects, hoặc tên gọi khác như chúng ta cũng biết, Observable, cập nhật những Observer bằng interface chung.
Observer Pattern đạt được “khớp nối lỏng lẽo” trong đó Observable không biết gì về người quan sát (observer) , ngoài việc biết chúng implement interface Observer.
Bạn có thể push (đẩy) hoặc kéo (pull) dữ liệu từ Observable được khi sử dụng mẫu Observer Pattern (kéo(pull) được coi là chính xác hơn).
Không phụ thuộc vào một thứ tự thông báo cụ thể cho những Observer của bạn.
Java có một số triển khai Observer Pattern, chứa bên trong java.util.Observable.
Xem qua các vấn đề khi triển khai java.util.Observable.
Đừng sợ tạo ra Observable của riêng bạn nếu cần.
Swing sử dụng rất nhiều Observer Pattern, cũng như nhiều GUI framework.
Bạn cũng tìm thấy mẫu này ở nhiều nơi khác, bao gồm JavaBeans và RMI.
