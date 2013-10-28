'use strict';

var controleProcesso = {};

var App = angular.module('controleProcesso',
    ['controleProcesso.filters', 'controleProcesso.services', 'controleProcesso.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function($routeProvider) {
    // == car
    $routeProvider.when('/cars/new', {
        templateUrl: 'cars/edit',
        controller: CarController
    }).when('/cars/list', {
        templateUrl: 'cars/list',
        controller: CarController
    }).when('/cars/edit/:car', {
        templateUrl: 'cars/edit',
        controller: CarController
    });
    // == evento diário
    $routeProvider.when('/evento-diario/adicionar', {
        templateUrl: 'eventodiario/edit',
        controller: EventoDiarioController
    }).when('/evento-diario/listar', {
        templateUrl: 'eventodiario/list',
        controller: EventoDiarioController
    }).when('/evento-diario/editar/:id', {
        templateUrl: 'eventodiario/edit',
        controller: EventoDiarioController
    });
    // == trains
    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    // == railwaystations
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    // == cidades
    $routeProvider.when('/cidades', {
        templateUrl: 'cidades/layout',
        controller: CidadeController
    });

    $routeProvider.otherwise({
        redirectTo: '/home'
    });
}]);
