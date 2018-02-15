# Cadastro de pessoas físicas utilizando MariaDB

## IDE's utilizadas

1. NetBeans
1. HeidiSQL

## Resumo

Para maior praticidade na utilização de bibliotecas externas, o projeto foi criado no padrão Maven, aonde foi importado a biblioteca [JSON-simple](https://github.com/fangyidong/json-simple), o [conector oficial do MariaDB](https://downloads.mariadb.org/connector-java/) e o padrão de layout Absolute para otimização do Java Swing.

## Classes
- Cadastro: Classe modelo para transferencia de dados entre classes.
- CpfValidator: Classe estática com um único método **validar()** para validação de CPF. O método recebe um String e retorna um boolean, aonde *true* representa que o CPF é válido.
- DatabaseHandler: Classe singleton com métodos para conectar ao banco ( **conectar()** ), inserir valores ao banco (**inserir()**, que recebe um objeto Cadastro como requisito) e um método para exportar os cadastros do banco para um arquivo .txt (**imprimir()**).
- JsonHandler: Classe para verificar integridade do endereço CEP recebido e requisitar os dados adicionais a respeito, para otimizar o tempo de preenchimento.

