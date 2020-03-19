# Mocks e teste unitarios.
Exemplo de testes unitários utilizando mocks, usando o easymock, feito para aula de programação 3 do professor Daniel Abella.

A classe principal consiste em apenas algumas funções matematicas basicas, que utilizam um drive de calculadora para fazê-las.

Para os teste existe uma interface que com os métodos usados na classe principal, que será usado para mock.

# Testes
* Default mock `SuperCalculatorTestWithDefaultMock`

  Este testes foram feitos para mostrar usos e conceitos gerais do comportamento de testes mocks.
  * O primeiro `addAndDoubleTeste1` é apenas um teste básico para mostrar com é feito, ele não vai falhar.
  
  * O segundo `addAndDoubleTeste2` servira para mostrar que o teste falhará se os parâmetros esperados não forem passados de forma correta.
  
  * O terceiro `addAndDoubleTest3` servirá para mostrar que ele falhará se todos os métodos que forem especificados para o mock, não forem 
    chamados.
    
  * O quarto `addAndDoubleTest4` servira para mostrar o metodo times, que especifica quantas vezes o mock deverá esperar que a aquele
    método seja chamado, ele vai falhar.
    
  * O quinto `addAndMultiplyTest` é apenas para mostrar como funciona quando o mock tem vários comportamentos, no caso ele é chamado
    duas vezes para realizar duas funções diferentes.
    
  * O sexto `divisionByZeroTest` servirá para mostrar quando queremos que o mock lançe uma exceção.
* Strict mock `SuperCalculatorTestWithStricMock`

  Estes testes foram feitos para mostrar o comportamento dos mocks do tipo strict
  * O primeiro `addAndMultiplyTest1` teste é feito apenas para comparação, ele não vai falhar.
  
  * O segundo `addAndMultiplyTest2` é onde podemos ver a diferença do strict mock, pois ele espera que os comportamentos sejam chamados, na ordem
    especificada no teste, no caso o metodo `CalculatorDrive.multiply` e em seguida `CalculatorDrive.add`, como no metodo testado, a
    ordem não bate com a esperada, ele vai falhar.
