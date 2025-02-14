Reflection 1

Pada modul task 1 yang telah saya kerjakan, saya telah mengimplementasikan 1 prinsip
dari clean code principles, dimana saya mengimplementasikan
layout formatting sebagai bagian dari clean code, dengan tujuan mematuhi protokol struktural
program yang telah disertakan pada modul pembelajaran, kemudian pada prinsip secure coding, saya 
belum mengimplementasikan apapun karena dirasa, belum ada prinsip secure coding yang telah saya 
implementasikan pada task 1 dari modul tutorial terkait.

Reflection 2

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









