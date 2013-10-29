'use strict';

/**
 * CarController
 * @constructor
 */
var PessoaFisicaController = function($scope, $http, $routeParams) {
    $scope.pessoaFisica = {};
    $scope.fetchPessoasList = function() {
        $http.get('pessoafisica/pessoafisicalist.json').success(function(pList) {
            $scope.pessoaFisicas = pList;
        });
    };

    $scope.editPessoaFisica = function() {
//        console.log('teste');
        $http.get('pessoafisica/editPessoaFisica/' + $routeParams.p).success(function(p) {
            $scope.pessoaFisica = p;
        });
    };

    $scope.addNewPessoaFisica = function(pessoaFisica) {
        $scope.resetError();
        console.log('teste');
        $http.post('pessoafisica/add', pessoaFisica).success(function() {
            $scope.fetchPessoasList();
            $scope.pessoaFisica.nome = '';
            $scope.pessoaFisica.sobrenome = '';
            $scope.pessoaFisica.cpf = '';
            $scope.pessoaFisica.rg = '';
            $scope.pessoaFisica.email = '';
            $scope.pessoaFisica.telefone = '';

        }).error(function() {
            $scope.setError('Não foi possível adicionar a nova Pessoa ' + pessoaFisica);
        });
//        $scope.pessoaFisica = ;
    };

    $scope.removePessoa = function(pessaoFisica) {
        $http.delete('pessoafisica/removePessoaFisica/' + pessaoFisica).success(function() {
            $scope.fetchPessoasList();
        });
    }

    $scope.removeAllPessoas = function() {
        $http.delete('pessoafisica/removeAllPessoas').success(function() {
            $scope.fetchPessoasList();
        });

    };
    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }
    $scope.fetchPessoasList();
//    $scope.editPessoaFisica();

};
