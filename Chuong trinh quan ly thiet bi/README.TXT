Hướng dẫn sử dụng:
1.Import các database trong thư mục "database" vào cơ sở dữ liệu
2.Thay đổi file config.properties cho phù hợp với thiết lập sql sever của bạn:
user=sa
trong đó "sa" là tên tài khoản quản trị trong cơ sở dữ liệu

password=12345678
trong đó"12345678" là mật khẩu của tài khoản quản trị trong cơ sở dữ liệu

DATABASE_LINK=jdbc:sqlserver://EMTRAI\\SQLEXPRESS
trong đó"jdbc:sqlserver://EMTRAI\\SQLEXPRESS" là DATABASE_LINK của sql sever

port=1433
1433 là cổng đang mở kết nối của sql sever. (có thể tìm thấy tại sql sever configuration manager, thông thường là cổng 1433) 
 
databaseName=quanlythietbi
"quanlythietbi" là tên database đã import

(video tham khảo khi lập trình kết nối csdl: https://www.youtube.com/watch?v=iEPX-MLZNKc ) 
3. thiết lập tài khoản được phép đăng nhập vào chương trình trong file Account.txt

ví dụ:
account admin pass 123456
account user pass 12345
account anotherUser pass 123 

=>đã thiết lập sẵn 3 tài khoản admin , user , và  anotherUser 
4.chon file thực thi để chạy chương trình. Đăng nhập và mật khẩu đã thiết lập sẵn 3 tài khoản như ở mục trên.
5.lưu ý: trước khi thoát chương trình cần chọn chức năng " lưu dữ liệu"  để lưu phiên làm việc của bạn cho sql sever.
