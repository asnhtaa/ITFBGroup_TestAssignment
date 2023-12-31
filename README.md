# ITFBGroup_TestAssignment

## Сценарий автотеста

1. Перейти на https://market.yandex.ru
2. Нажать на «Каталог»
3. Навести курсор на «Зоотовары, в блоке «Для кошек» нажать на «Лакомства»
4. Установить фильтры:
    a. по цене: от 50 руб до 150 руб
    b. способ доставки: «С учетом доставки курьером»
    c. производитель: «Whiskas»
5. Перейти в первый товар в списке, нажать на кнопку «Сравнить»
6. Вернуться на предыдущую страницу
7. В фильтре снять галочку с производителя «Whiskas» и установить производителя «Мнямс»
8. Перейти во второй товар в списке, нажать на кнопку «Сравнить»
9. Перейти в «Сравнение», проверить, что имена товаров в сравнении соответствуют именам товаров, добавленных на шагах 5 и 8
10. Проверить, что сумма стоимостей товаров не превышает 300 руб
11. Удалить товар производителя «Whiskas» из сравнения и проверить, что товар производителя «Whiskas» не отображается
12. Нажать на «Удалить список» (значок мусорного бака), проверить, что товары не отображаются

P.S. Если указанные производители отсутствуют, использовать любые два на усмотрение.


## Инструкции по настройке

1) Установите Java Development Kit (JDK) на вашей системе. Вы можете скачать JDK с [официального сайта Oracle](https://www.oracle.com/). Проверьте установку Java, выполнив следующую команду в командной строке:

```
   java -version
```

2) Установите Apache Maven на вашей системе. Вы можете скачать его с [сайта Apache Maven](https://maven.apache.org/).

3) Для скачивания задания на проверку навыков автоматизации UI выполните следующую команду:


```
git clone https://github.com/asnhtaa/ITFBGroup_TestAssignment.git
```

4) Откройте командную строку, перейдите в директорию проекта и выполните следующую команду для сборки проекта и запуска тестов:

```
   mvn clean test
```

