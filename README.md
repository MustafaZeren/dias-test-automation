# Hepsiburada UI Test Otomasyonu

Bu proje, **Selenium** ve **CucumberBDD** kullanılarak **Hepsiburada** üzerinde belirli filtrelerle tablet arayıp en pahalı ürünü sepete ekleyerek fiyat doğrulaması yapan bir **UI test otomasyonu** sağlar.

## 📌 Proje Yapısı

```
hepsiburada-automation/
│── src/
│   ├── test/
│   │   ├── java/com/zeren/hepsiburada/
│   │   │   ├── steps/
│   │   │   ├── tests/
│   │   │   ├── runner/
│   │   │   ├── pages/
│   │   │   │   ├── MainPage/
│   │   │   │   ├── CategoryPage/
│   │   │   │   ├── ProductPage/
│   │   │   │   ├── CartPage/
│   │   │   │   ├── utils/
│   │   ├── resources/features/
```

## 📦 Kullanılan Teknolojiler
- **Java 17**
- **Selenium WebDriver**
- **Cucumber BDD**
- **JUnit**
- **Maven**

## 🚀 Kurulum
### 1️⃣ Projeyi Klonlayın
```sh
git clone https://github.com/kullanici/hepsiburada-automation.git
cd hepsiburada-automation
```

### 2️⃣ Bağımlılıkları Yükleyin
```sh
mvn clean install
```

### 3️⃣A) Testleri Çalıştırın
```sh
mvn test
```
### 3️⃣A) Testleri Çalıştırın
Test Runner dosyası üzerinden "RUN" tuşu ile kullanılabilir. (IntellijIDEA)


## 🎯 Test Senaryosu

**Feature Dosyası:** `HepsiBurada.feature`

```gherkin
Feature: Category Navigation
  Scenario: Navigate to a specific category
    Given Open main page
    When Navigate to category
    When Select "Apple" category from left side menu
    When Find the most expensive product
    When Add to cart
    When Go to cart
    Then Check price from the cart
```

## 📌 Kod Açıklamaları

### **1️⃣ Helper Sınıfı** (`Helper.java`)
- WebDriver yardımcı metotlarını içerir.
- Sayfa navigasyonu, element bulma, tıklama ve metin kontrolü gibi işlemleri yönetir.

### **2️⃣ Sayfa Nesneleri**
#### **🟠 MainPage** (`MainPage.java`)
- Ana sayfaya yönlendirme yapar.
- Kategorilere yönlendirme yapar.

#### **🟠 CategoryPage** (`CategoryPage.java`)
- Kategori seçim işlemlerini yapar.
- En pahalı ürünü bulup tıklar.

#### **🟠 ProductPage** (`ProductPage.java`)
- Sepete ekleme işlemlerini yapar.

#### **🟠 CartPage** (`CartPage.java`)
- Sepetteki fiyat doğrulamasını yapar.

### **3️⃣ Test Adımları** (`HepsiBuradaSteps.java`)
- Cucumber'daki **Given, When, Then** adımlarını içerir.
- Test senaryolarını gerçekleştirir.

### **4️⃣ Test Çalıştırıcı** (`TestRunner.java`)
- Cucumber testlerini başlatan sınıftır.

## 🔥 Öne Çıkan Özellikler
✅ **En pahalı ürünün otomatik bulunması**  
✅ **Fiyat doğrulaması yapılması**  
✅ **Kategori bazlı seçim işlemi**  
✅ **Cucumber ile BDD (Behavior Driven Development) senaryoları**

## 📌 Raporlama
Test çalıştırıldıktan sonra **HTML raporu** şu dizinde oluşturulur:
```
target/cucumber-reports.html
```
Bu raporu tarayıcıda açarak test sonuçlarını görebilirsiniz.

## 📌 Paralel ve Cross-Browser Test Desteği
Şu anda bu destek bulunmamaktadır. En kısa zamanda eklenecektir.

## 📞 Destek
MUSTAFA ZEREN:

zeren.mustafa37@gmail.com

+90 5380311113