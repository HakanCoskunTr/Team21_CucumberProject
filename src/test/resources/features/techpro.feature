Feature: Techproeducation Title Testi
  Scenario: TC01_sayfanin baslik testi
    Given techproeducation sayfasina gidilir
    When sayfa basligi yazdirilir
    Then sayfa basliginda Bootcamp yazisi oldugu test edilir
    And sayfa kapatilir