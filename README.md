# Telefon Rehberi Uygulaması

Bu proje, Java kullanılarak geliştirilmiş konsol tabanlı bir telefon rehberi uygulamasıdır. Kullanıcıdan alınan kişi bilgilerini (Ad, Telefon, Email) belirli format kurallarına göre doğrular, düzenler ve bir metin dosyasına raporlar.

## 🚀 Özellikler

* **Veri Girişi:** Kullanıcıdan Ad Soyad, Telefon ve Email bilgisi alır.
* **Validasyon (Regex):**
    * Telefon numaraları `05XXXXXXXXX` formatında (11 haneli ve rakam) olmalıdır.
    * Email adresleri standart e-posta formatına uygun olmalıdır.
* **Otomatik Formatlama:**
    * **İsimler:** Tamamı büyük harfe çevrilir.
    * **Telefon:** Okunabilir parçalara ayrılır (Örn: `0532 123 45 67`).
    * **Email:** Tamamı küçük harfe çevrilir.
* **Raporlama:**
    * Geçerli kayıtlar düzenlenmiş formatta kaydedilir.
    * Geçersiz kayıtlar hata sebepleriyle birlikte kaydedilir.
    * Tüm veriler `telefon_rehberi.txt` dosyasına yazdırılır.
* **İstatistikler:** İşlem sonunda toplam, geçerli ve geçersiz kayıt sayıları raporlanır.

## 🛠️ Kurulum ve Çalıştırma

Bu projeyi bilgisayarınızda çalıştırmak için Java Development Kit (JDK) yüklü olmalıdır.

1.  Projeyi bilgisayarınıza indirin veya klonlayın.
2.  Terminali veya Komut İstemi'ni (CMD) açın.
3.  Proje dizinine gidin.
4.  Kodu derleyin:
    ```bash
    javac Main.java
    ```
5.  Uygulamayı çalıştırın:
    ```bash
    java Main
    ```

## 📂 Çıktı Örneği (telefon_rehberi.txt)

Program çalıştırıldıktan sonra oluşturulan dosya içeriği şuna benzer:

```text
===== TELEFON REHBERİ =====
Kisi 1
Ad Soyad: AHMET YILMAZ
Telefon: 0532 123 45 67
Email: ahmet@example.com
Durum: GEÇERLİ
----------------------------
Kisi 2
Ad Soyad: Mehmet Demir
Durum: GEÇERSİZ
Hata: Telefon formati hatali (05XXXXXXXXX olmali). 
----------------------------

===== İSTATİSTİKLER =====
Toplam kayit: 2
Gecerli: 1
Gecersiz: 1
```
## 👨‍💻 Geliştirici
[Mustafa Tunç]


