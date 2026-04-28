@echo off
title Menjalankan Aplikasi Gaji Karyawan PT Sintory
echo Sedang membuka aplikasi...

:: Coba jalankan dengan perintah java biasa
java -version >nul 2>&1
if %errorlevel% equ 0 (
    java -jar AplikasiGaji.jar
) else (
    :: Jika gagal, gunakan jalur absolut ke JDK NetBeans
    echo [INFO] Menggunakan jalur Java NetBeans...
    "C:\Program Files\Apache NetBeans\jdk\bin\java.exe" -jar AplikasiGaji.jar
)

if %errorlevel% neq 0 (
    echo.
    echo ERROR: Aplikasi gagal dibuka. 
    echo Pastikan Java terinstal dengan benar.
)
pause
