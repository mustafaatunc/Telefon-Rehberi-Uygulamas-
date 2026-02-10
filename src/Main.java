import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder rehber = new StringBuilder();

        // Regex Desenleri
        // Telefon: 05 ile başlayıp 11 haneli olmalı (rakam)
        String telefonRegex = "^05\\d{9}$";
        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

        System.out.println("Kaç kişi ekleyeceksiniz?");
        int kisiSayisi = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        // İstatistik Değişkenleri [cite: 59, 60, 61]
        int toplamKayit = kisiSayisi;
        int gecerliKayit = 0;
        int gecersizKayit = 0;

        rehber.append("===== TELEFON REHBERİ =====\n");

        for (int i = 0; i < kisiSayisi; i++) {
            System.out.println((i + 1) + ". Kisi");
            
            System.out.print("Ad Soyad: ");
            String adSoyad = scanner.nextLine();
            
            System.out.print("Telefon (05XXXXXXXXX): ");
            String telefon = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();

            // Validasyon Kontrolü
            boolean isTelefonValid = Pattern.matches(telefonRegex, telefon);
            boolean isEmailValid = Pattern.matches(emailRegex, email);

            rehber.append("Kisi ").append(i + 1).append("\n");

            if (isTelefonValid && isEmailValid) {
                // [cite: 50] GEÇERLİ KAYIT İŞLEMLERİ
                gecerliKayit++;

                // [cite: 52] Ad soyadı büyük harfe çevir
                rehber.append("Ad Soyad: ").append(adSoyad.toUpperCase()).append("\n");

                //  Telefonu formatla (substring ile): 0532 123 45 67
                String formatliTel = telefon.substring(0, 4) + " " + 
                                     telefon.substring(4, 7) + " " + 
                                     telefon.substring(7, 9) + " " + 
                                     telefon.substring(9);
                rehber.append("Telefon: ").append(formatliTel).append("\n");

                // [cite: 53] E-maili küçük harfe çevir
                rehber.append("Email: ").append(email.toLowerCase()).append("\n");
                
                // [cite: 54] Durum: GEÇERLİ
                rehber.append("Durum: GEÇERLİ\n");
                
                System.out.println("Kayıt başarılı!\n");

            } else {
                // [cite: 55] GEÇERSİZ KAYIT İŞLEMLERİ
                gecersizKayit++;
                
                rehber.append("Ad Soyad: ").append(adSoyad).append("\n"); // Değişiklik yok
                rehber.append("Durum: GEÇERSİZ\n");

                // [cite: 58] Hatanın ne olduğunu belirtme
                rehber.append("Hata: ");
                if (!isTelefonValid) {
                    rehber.append("Telefon formati hatali (05XXXXXXXXX olmali). ");
                }
                if (!isEmailValid) {
                    rehber.append("Email formati hatali.");
                }
                rehber.append("\n");
                
                System.out.println("Hatali format!\n");
            }
            rehber.append("----------------------------\n");
        }

        // [cite: 90] İstatistikleri StringBuilder'a ekle
        rehber.append("\n===== İSTATİSTİKLER =====\n");
        rehber.append("Toplam kayit: ").append(toplamKayit).append("\n");
        rehber.append("Gecerli: ").append(gecerliKayit).append("\n");
        rehber.append("Gecersiz: ").append(gecersizKayit).append("\n");

        // [cite: 62, 63] Dosyaya Yazma İşlemi (BufferedWriter)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("telefon_rehberi.txt"))) {
            writer.write(rehber.toString());
            System.out.println("Rehber 'telefon_rehberi.txt' dosyasına kaydedildi!");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
        
        scanner.close();
    }
}