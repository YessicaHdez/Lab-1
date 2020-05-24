var assert = require('assert');
var javascriptFunctions = require('C:\\Users\\Yessica\\Documents\\Visual Studio 2017\\LAB8\\testJS\\javascriptFunctions.js');
var octalConverter = require('C:\\Users\\Yessica\\Documents\\Visual Studio 2017\\LAB8\\testJS\\OctalConverter.js');
describe('givenTwoIntegerWhenSumThenSucess()', function(){

    it('sum(1,2) = 3',function(){
        var a = 1;
        var b = 2;
        var expectedResult =3;

        var actualResult = javascriptFunctions.sum(a,b);

        assert.equal(expectedResult,actualResult);


    });
});
describe('givenDecimalOne_thenReturnOctalOne', function () {
    it('octalian(1) = 1', function () {
        
        //Given
        var decimal = 1;
        var expectedResult = 1;

        //When
        var actualResult = octalConverter.octalConverter(decimal);

        //Then
        assert.equal(expectedResult, actualResult);
    });
});

describe('givenDecimalTwo_thenReturnOctalTwo', function () {
    it('octalian(2) = 2', function () {
        
        //Given
        var decimal = 2;
        var expectedResult = 2;

        //When
        var actualResult = octalConverter.octalConverter(decimal);

        //Then
        assert.equal(expectedResult, actualResult);
    });
});

describe('givenDecimalEight_thenReturnOctalTen', function () {
    it('octalian(8) = 10', function () {
        
        //Given
        var decimal = 8;
        var expectedResult = 10;

        //When
        var actualResult = octalConverter.octalConverter(decimal);

        //Then
        assert.equal(expectedResult, actualResult);
    });
});

describe('givenDecimalNintyfive_thenReturnOctalOneThirtyseven', function () {
    it('octalian(95) = 137', function () {
        
        //Given
        var decimal = 95;
        var expectedResult = 137;

        //When
        var actualResult = octalConverter.octalConverter(decimal);

        //Then
        assert.equal(expectedResult, actualResult);
    });
});

describe('givenDecimalTwentyFortyeight_thenReturnOctalFourK', function () {
    it('octalian(2048) = 4000', function () {
        
        //Given
        var decimal = 2048;
        var expectedResult = 4000;

        //When
        var actualResult = octalConverter.octalConverter(decimal);

        //Then
        assert.equal(expectedResult, actualResult);
    });
});