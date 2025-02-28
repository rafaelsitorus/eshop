Reflection 1. Modul 1:

Pada modul task 1 yang telah saya kerjakan, saya telah mengimplementasikan 1 prinsip
dari clean code principles, dimana saya mengimplementasikan
layout formatting sebagai bagian dari clean code, dengan tujuan mematuhi protokol struktural
program yang telah disertakan pada modul pembelajaran, kemudian pada prinsip secure coding, saya 
belum mengimplementasikan apapun karena dirasa, belum ada prinsip secure coding yang telah saya 
implementasikan pada task 1 dari modul tutorial terkait.

Reflection 2. Modul 2:

Setelah menulis unit test, saya merasa lebih percaya diri bahwa kode yang ditulis berfungsi sesuai ekspektasi. 
Jumlah unit test yang perlu dibuat dalam sebuah kelas bergantung pada kompleksitas dan fungsionalitas kelas tersebut, 
seharusnya, setiap metode dan skenario edge case harus diuji. Untuk memastikan unit test cukup, 
kita dapat menggunakan metrik seperti code coverage untuk melihat sejauh mana kode kita diuji, seperti statement, 
branch, atau method coverage. Namun, meskipun mencapai 100% code coverage dapat membantu memastikan bahwa semua bagian kode dijalankan selama pengujian, 
itu tidak menjamin bahwa kode bebas dari bug, karena coverage tidak mengukur kualitas atau kecakupan logika pengujian. 
Oleh karena itu, penting juga untuk mempertimbangkan skenario uji yang realistis dan kritis.

Menambahkan functional test suite baru dengan setup dan variabel yang sama seperti sebelumnya dapat menurunkan kualitas kode karena adanya pengulangan 
(redundancy), yang melanggar prinsip DRY (Don't Repeat Yourself). Duplikasi kode ini meningkatkan risiko inkonsistensi dan membuat pemeliharaan lebih sulit. 
Untuk memperbaiki masalah ini, kita dapat mengabstraksi setup dan konfigurasi yang berulang ke kelas atau metode base test yang dapat diwarisi oleh semua functional test suites. 
Dengan cara ini, kode menjadi lebih terorganisir, lebih mudah dikelola, dan lebih bersih, sesuai dengan prinsip clean code.

Reflection 1. modul 2:

Selama proses ini, saya memperbaiki beberapa masalah kualitas kode. Salah satu yang utama adalah dalam metode edit pada ProductRepository, di mana semua produk dalam daftar 
diperbarui dengan nilai yang sama karena tidak ada pengecekan productId. Saya memperbaikinya dengan menambahkan validasi agar hanya produk yang sesuai yang diubah, sehingga tidak 
mengganggu data lain dalam daftar.

Reflection 2. modul 2:

Mengenai implementasi CI/CD, saya yakin proses yang dilakukan sudah memenuhi definisi CI/CD. Setiap kali ada perubahan pada kode, pengujian 
berjalan secara otomatis untuk memastikan tidak ada error sebelum kode digabungkan. Selain itu, analisis kualitas kode dilakukan untuk mendeteksi potensi masalah sejak dini. Jika semua 
tahapan berhasil, aplikasi langsung dideploy ke PaaS tanpa intervensi manual, menjadikan alur kerja lebih efisien.

link koyeb: https://wilful-austina-rafaelsitorus-cefb6a81.koyeb.app/product/list

SOLID Principles Explanation. Modul 3:

Have you implemented SRP? If yes, explain the principle; if not, please change your code as per SRP. Keep in mind that SRP is a class that has only one reason to change. In other words, a class should have only one responsibility or encapsulate only one aspect of the software's functionality.

Ya, Saya telah mengimplementasikan SRP dalam tugas kali ini, Independensi pada ProductController, antara Product dan Car
Controller merupakan implementasi SRP secara nyata. Dimana suatu kelas hanya memiliki responsibilitas tertentu
untuk suatu aspek fungsional dalam program saya.

Have you implemented OCP? If yes, explain the principle, if not, please modify your code as per OCP. Remember that OCPs are software entities (classes, modules, functions, etc.) that should be open for development but closed for modification. This means you should be able to extend a module's behavior without changing its source code.

Ya, saya telah mengimplementasikan OCP dalam tugas kali ini. Independensi pada CarServiceImpl menggunakan abstraksi
untuk memungkinkan penambahan fitur baru tanpa perlu mengubah kode yang sudah ada. Dimana suatu kelas dapat diperluas
tanpa harus dimodifikasi, sesuai dengan prinsip OCP.

Have you implemented LSP? If yes, explain the principle; if not, modify your code to suit the LSP. It should be remembered that the LSP is an object from the superclass that must be replaced with an object from the subclass without affecting the correctness of the program. In other words, subclasses must be replaceable with their base class without changing desired program properties, such as correctness and consistency.

Ya, saya telah mengimplementasikan LSP dalam tugas kali ini. Subclass dari Product, seperti CarProduct, 
dapat menggantikan superclass tanpa mengubah perilaku program. Dimana setiap turunan dapat digunakan 
sebagai pengganti tanpa mempengaruhi konsistensi sistem, sesuai dengan prinsip LSP.

Have you implemented an ISP? If yes, explain the principle; if not please modify your code according to ISP. Keep in mind that ISPs recommend that large interfaces be broken down into smaller, more specific interfaces so that clients only need to know the methods that are relevant to them.

Ya, saya telah mengimplementasikan ISP dalam tugas kali ini. Antarmuka Product dan Car
dipisahkan agar setiap klien hanya bergantung pada metode yang mereka butuhkan. Dimana pemecahan antarmuka 
besar menjadi lebih spesifik menghindari dependensi yang tidak diperlukan, sesuai dengan prinsip ISP.

Have you implemented DIP? If yes, explain the principle; if not change your code as per DIP. Note that DIP recommends that high-level modules do not depend on low-level modules. Both must rely on abstractions. Additionally, abstraction should not depend on details; details must rely on abstraction.

Ya, saya telah mengimplementasikan DIP dalam tugas kali ini. ProductController tidak bergantung 
langsung pada ProductService, melainkan melalui abstraksi ProductServiceImpl. Dimana dependensi pada detail 
dihindari dengan menggunakan abstraksi, sehingga ketergantungan antar modul menjadi fleksibel dan mudah diuji, 
sesuai dengan prinsip DIP.

Reflection 1. Modul 3:

1. Saya mengimplementasikan Solid Principle dalam project saya kali ini
2. Kelebihan dari SOLID principle berdampak pada modularitas kode, fleksibilitas, dan kemudahan iklim pengembangan, contohnya pada SRP, 
dimana SRP mempermudah pemeliharaan kode dengan memisahkan tanggung jawab. 
Contohnya, ProductController yang hanya menangani request terkait produk, sedangkan CarController menangani request terkait mobil.
3. Tanpa menerapkan prinsip SOLID, kode dalam proyek menjadi sulit dipelihara, sulit diperluas, dan rentan terhadap bug. 
Setiap perubahan bisa berdampak luas, mengakibatkan ketergantungan yang tidak perlu dan menyulitkan pengujian. 
Dengan menerapkan SOLID, kode menjadi lebih modular, fleksibel, dan mudah dikembangkan tanpa harus merombak sistem yang sudah ada. 
Hal ini memastikan proyek tetap scalable, mudah dikelola, dan memiliki struktur yang jelas, sehingga pengembangan jangka panjang lebih efisien.
















