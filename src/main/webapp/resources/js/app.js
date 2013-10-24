'use strict';

var controleProcesso = {};

var App = angular.module('controleProcesso', ['controleProcesso.filters', 'controleProcesso.services', 'controleProcesso.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function($routeProvider) {
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

    $routeProvider.otherwise({
        redirectTo: '/home'
    });
}]);

App.directive('jqdatepicker', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
         link: function (scope, element, attrs, ngModelCtrl) {
            element.datepicker({
                dateFormat: 'DD, d  MM, yy',
                onSelect: function (date) {
                    scope.date = date;
                    scope.$apply();
                }
            });
        }
    };
});
