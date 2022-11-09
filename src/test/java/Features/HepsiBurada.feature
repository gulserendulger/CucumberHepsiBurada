Feature: HepsiBurada Senaryolari
  Scenario: HepsiBurada uygulamasına giris yapma
    Given Uygulamaya giris yapilir
    When Arama ekranindan bilgisayar aratilir
    And Urunlerden bir tanesi secilir
    And Secilen urun sepete eklenir
    Then Sepette secilen urunun gozukmesi gerekmektedir