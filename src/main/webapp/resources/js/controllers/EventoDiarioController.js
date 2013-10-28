'use strict';

/**
 * CidadeController
 * @constructor
 */
var EventoDiarioController = function($scope, $http, $routeParams) {
    $scope.evento = {};
    $scope.editMode = false;
    
    $scope.fetchEventoList = function() {
        $http.get('eventodiario/eventoslist.json').success(function(rsList) {
            $scope.eventos = rsList;
        });
    }

    $scope.newEvento = function(){
        $scope.evento.descricao = '';
        $scope.evento.momento = new Date();
    }

    $scope.adicionaEvento = function(evento) {
        $scope.resetError();
        $http.post('eventodiario/save', evento).success(function() {
            $scope.fetchEventoList();
            $scope.newEvento();
        }).error(function() {
            $scope.setError('Não foi possível adicionar o novo Evento ' + evento);
        });
    }
    
    $scope.editEvento = function(){    
        $scope.resetError();    
        $http.get('eventodiario/edit/' + $routeParams.id).success(function(evento){
            $scope.evento = evento;
        }).error(function() {
            $scope.setError('Não foi editar o evento ');
        });   
        $scope.editMode = true;
    }

    $scope.updateEvento = function(evento) {
        $scope.resetError();
        $http.put('eventodiario/update', evento).success(function() {
            $scope.fetchEventoList();
            $scope.newEvento();
        }).error(function() {
            $scope.setError('Não foi possível atualizar');
        });
    }

    $scope.removeEvento = function(id) {
        $scope.resetError();
        $http.delete('eventodiario/remove/' + id).success(function() {
            $scope.fetchEventoList();
        }).error(function() {
            $scope.setError('Não foi possível remover o evento');
        });
    }

    $scope.removeAllEventos = function() {
        $scope.resetError();
        $http.delete('eventodiario/removeAll').success(function() {
            $scope.fetchEventoList();
        }).error(function() {
            $scope.setError('Não foi possível remover todas os eventos');
        });

    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchEventoList();
    if($routeParams.id != 'undefined'){
         $scope.editEvento();
    }
    $scope.predicate = 'momento';
}