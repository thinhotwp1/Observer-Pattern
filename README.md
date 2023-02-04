Link github: https://github.com/thinhotwp1/Observer-Pattern.git
Link bài viết chương 2:  Chương 2: Observer Pattern (Người quan sát)
Link drive:  https://docs.google.com/document/d/1S-JXrjglPbQ7pDbBFYs3d6Malo_ULCgNc_ZG7u9sIVY/edit?usp=sharing


Một nhà sản xuất có thể có nhiều người đăng kí nhận bài báo mới nhất, nhà sản xuất là Subject (hay Obsevible) và những người đăng kí gọi là Observer. Khi cập nhật hay có thông báo nhà sx sẽ gửi tới tất cả những người đăng kí.

Observer Pattern: Sức mạnh của khớp nối lỏng lẻo (Loose Coupling)
Khi hai đối tượng được ghép lỏng lẻo, chúng có thể tương tác, nhưng chúng biết rất ít về nhau.
Observer pattern cung cấp một thiết kế đối tượng trong đó subjects và observers được ghép lỏng lẻo với nhau.
Tại sao ư?
Điều duy nhất mà Subject biết về một người quan sát (observer) là nó implement một interface nhất định (interface Observer). Nó không cần phải biết lớp con cụ thể của Observer, những gì nó làm, hoặc bất cứ điều gì khác về nó.
Chúng tôi có thể thêm người quan sát (observer) mới bất cứ lúc nào. Bởi vì điều duy nhất mà đối tượng Subject cần là một danh sách các object con implement interface Observer, chúng tôi có thể thêm Observer mới bất cứ khi nào chúng tôi muốn. Trên thực tế, chúng ta có thể thay thế bất kỳ Observer nào trong runtime thông qua setter và đối tượng sẽ tiếp tục chạy. Tương tự như vậy, chúng ta có thể loại bỏ các observer bất cứ lúc nào.

Thay đổi Subject hoặc Observer sẽ không ảnh hưởng đến đối tượng còn lại.
Do cả hai được ghép lỏng lẻo, chúng có thể tự do thay đổi, miễn là các đối tượng vẫn đáp ứng được trách nhiệm của chúng để implements interface Subject hoặc Observer.

Có một vấn đề: Khi 1 observer không muốn nhận dữ liệu update liên tục mà chỉ muốn nhận dữ liệu khi nhiệt độ thay đổi từ 1 độ C trở lên thì sao, khi đó ta có thể dùng thêm setChanged để cho observer có thể chủ động nhận thông báo có sự thay đổi từ Object thay vì bị động như trên
Phương thức setChanged() được sử dụng để biểu thị rằng trạng thái đã thay đổi và khi đó notifyObservers(), khi được gọi, nên cập nhật trình observers của nó. Nếu notifyObservers() được gọi mà không gọi setChanged() trước, người quan sát (observer) sẽ KHÔNG được thông báo. Hãy cùng nhìn vào “behind the scenes” của Observable để xem cách thức hoạt động của nó:

Tại sao điều này là cần thiết? Phương thức setChanged() giúp bạn linh hoạt hơn trong cách bạn cập nhật observer bằng cách cho phép bạn tối ưu hóa các thông báo. Ví dụ, trong trạm thời tiết của chúng tôi, hãy tưởng tượng nếu các phép đo của chúng tôi nhạy cảm đến mức chỉ số nhiệt độ dao động liên tục trong một vài phần mười của một độ. Điều đó có thể khiến đối tượng WeatherData liên tục gửi thông báo. Thay vào đó, chúng tôi có thể chỉ muốn gửi thông báo nếu nhiệt độ thay đổi hơn nửa độ và chúng tôi chỉ có thể gọi setChanged() sau khi điều đó xảy ra.
Bạn có thể không sử dụng chức năng này thường xuyên, nhưng nó có ở đó nếu bạn cần. Trong cả hai trường hợp, bạn cần gọi setChanged() để thông báo hoạt động. Nếu chức năng này là một cái gì đó hữu ích cho bạn, bạn cũng có thể muốn sử dụng phương thức clearChanged(), đặt trạng thái đã thay đổi thành false và phương thức hasChanged(), cho bạn biết trạng thái hiện tại của cờ changed.
Mặt tối của java.util.Observable
Vâng, một sự tìm hiểu tốt. Như bạn đã nhận thấy, Observable là một lớp, không phải là một interface, và tệ hơn nữa, nó thậm chí không implements một giao diện. Thật không may, việc triển khai java.util.Observable có một số vấn đề làm hạn chế tính hữu dụng và tái sử dụng của nó. Điều đó không thể nói rằng nó không tiện ích, nhưng có một số vấn đề lớn để đề phòng.
OBSERVABLE LÀ MỘT CLASS 
Bạn đã biết từ các nguyên tắc của chúng tôi, đây là một ý tưởng tồi, nhưng nó thực sự gây hại gì?
Đầu tiên, vì Observable là một lớp, bạn phải phân lớp nó. Điều đó có nghĩa là bạn có thể thêm vào hành vi có thể quan sát được vào một lớp hiện có đã mở rộng một siêu lớp khác. Điều này giới hạn tiềm năng tái sử dụng của nó (và không phải là lý do tại sao chúng ta đang sử dụng các mẫu ở đầu chương?).
Thứ hai, vì không có Observable interface, bạn thậm chí không thể tạo ra implementation hoạt động tốt với Java’s built-in Observer API. Bạn cũng không có tùy chọn hoán đổi triển khai java.util cho người khác (giả sử, multi-threaded implementation).

MỘT CHÚT NỀN TẢNG…
Hãy cùng xem một phần đơn giản của Swing API, JButton. Nếu bạn nhìn vào sâu trong triển khai của lớp superclass JButton, bạn sẽ thấy rằng nó có rất nhiều phương thức add/remove. Các phương thức này cho phép bạn thêm và xóa các observer, hoặc như chúng được gọi trong Swing, listeners, để lắng nghe các loại sự kiện khác nhau xảy ra trên thành phần Swing. Chẳng hạn, một ActionListener cho phép bạn nghe bất kỳ loại hành động nào có thể xảy ra trên một button, như Button click. Bạn sẽ tìm thấy nhiều loại listeners khác nhau trên Swing API

Tóm tắt
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
