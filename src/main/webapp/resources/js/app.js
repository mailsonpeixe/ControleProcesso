'use strict';

var controleProcesso = {};

var App = angular.module('controleProcesso', ['controleProcesso.filters', 'controleProcesso.services', 'controleProcesso.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/cars/edit', {
            templateUrl: 'cars/edit',
            controller: CarController
        }).when('/cars/list', {
            templateUrl: 'cars/list',
            controller: CarController
        });

        $routeProvider.when('/trains', {
            templateUrl: 'trains/layout',
            controller: TrainController
        });

        $routeProvider.when('/railwaystations', {
            templateUrl: 'railwaystations/layout',
            controller: RailwayStationController
        });
        $routeProvider.when('/cidades', {
            templateUrl: 'cidades/layout',
            controller: CidadeController
        });

        $routeProvider.otherwise({redirectTo: '/cars'});
    }]);
