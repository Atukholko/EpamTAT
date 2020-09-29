| Test case id | Test Scenario | Test Steps | Test Data | Expected results | Actual result | Pass/Fail |
| ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| TU01 | Check registration with valid data | 1.Go to site 21vek.by 2.Enter email 3.Click "продолжить" | Email= [dnapclexaby@gmial.com][PlOd] | Password recieved | As expected | Pass | 
| TU02 | Check registration with invalid data | 1.Go to site 21vek.by 2.Enter email 3.Click continue | Email= [aaagmail.com][PlOd] | Error: "неправильный формат" | As expected | Pass |
| TU03 | Check Customer Login with valid Data |  1.Go to site 21vek.by 2.Enter email 3.Enter password 4.Click "войти" | Email = [dnapclexaby@gmial.com][PlOd] Password = fffggg | User should Login into an application | As expected | Pass |
| TU04 | Check Customer Login with invalid Data | 1.Go to site 21vek.by 2.Enter email 3.Enter password 4.Click "войти" | Email = [ aaagmail][PlOd] Password = fffgggg | User should not Login into an application. Error:"Неправильный пароль.". Error:"Нет такого аккаунта." | As expected | Pass |
| TU05 | Check for customer personal information editing | 1.Go to site 21vek.by 2.Log in 3.Change your personal info | Name=Alexey Tukholko | Data changed | As expected | Pass |
| TU06 | Check for search with valid data | 1.Go to site 21vek.by 2.Type in search line | string="смартфон" | Search result is displayed | As expected | Pass |
| TU07 | Check for search with invalid data | 1.Go to site 21vek.by 2.Type in search line | string="шшшшшш" | Message:"Найдено 0 товаров" | As expected | Pass |
| TU08 | Add to Shopping Cart | 1.Go to site 21vek.by 2.Find goods 3.Click "В корзину" | - | Goods added to the shopping cart | As expected | Pass |
| TU09 | Place an order | 1.Go to site 21vek.by 2.Go to shopping cart 3.Click "Оформить заказ" 4.Insert info 4.Click "Подтвердить зказ" | Address="ул. Такая-то, д. 12" PhoneNumber=3752956686** | Order get status "Оформлен, ожидает подтверждения" | As expected | Pass |
