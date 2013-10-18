'use strict';

/**
 * CidadeController
 * @constructor
 */
var CidadeController = function($scope, $http) {
    $scope.cidade = {};
    $scope.editMode = false;

    $scope.fetchCidadesList = function() {
        $http.get('cidades/cidadeslist.json').success(function(rsList) {
            $scope.cidades = rsList;
        });
    }
    $scope.fetchCarsList = function() {
        $http.get('trains/trainslist.json').success(function(trainsList) {
            $scope.trains = trainsList;
        });
    }

    $scope.addNovaCidade = function(cidade) {

        $scope.resetError();

        $http.post('cidades/add', cidade).success(function() {
            $scope.fetchCidadesList();
            $scope.cidade.nome = '';
            $scope.cidade.estado = '';
            $scope.cidade.train.name = '';
            $scope.cidade.train.speed = '';
            $scope.cidade.train.diesel = false;

            $scope.cidade.train2.name = '';
            $scope.cidade.train2.speed = '';
            $scope.cidade.train2.diesel = false;

        }).error(function() {
            $scope.setError('Não foi possível adicionar a nova Cidade ' + cidade);
        });
    }

    $scope.updateCidade = function(cidade) {
        $scope.resetError();

        $http.put('cidades/update', cidade).success(function() {
            $scope.fetchCidadesList();
            $scope.cidade.nome = '';
            $scope.cidade.estado = '';

            $scope.cidade.train.name = '';
            $scope.cidade.train.speed = '';
            $scope.cidade.train.diesel = false;

            $scope.cidade.train2.name = '';
            $scope.cidade.train2.speed = '';
            $scope.cidade.train2.diesel = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Não foi possível atualizar');
        });
    }

    $scope.editCidade = function(cidade) {
        $scope.resetError();
        $scope.cidade = cidade;
        $scope.editMode = true;
    }

    $scope.removeCidade = function(id) {
        $scope.resetError();

        $http.delete('cidades/remove/' + id).success(function() {
            $scope.fetchCidadesList();
        }).error(function() {
            $scope.setError('Não foi possível remover cidade');
        });
    }

    $scope.removeAllCidades = function() {
        $scope.resetError();

        $http.delete('cidades/removeAll').success(function() {
            $scope.fetchCidadesList();
        }).error(function() {
            $scope.setError('Não foi possível remover todas as cidades');
        });

    };

    $scope.resetCidadesForm = function() {
        $scope.resetError();
        $scope.cidade = {};
        $scope.editMode = false;
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchCidadesList();
    $scope.fetchCarsList();

    $scope.predicate = 'id';
}