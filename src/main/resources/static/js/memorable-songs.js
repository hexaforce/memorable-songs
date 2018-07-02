'use strict';
var app = angular.module('MusicServer', ['ngRoute', 'ngSanitize']);
//  Route Config
//****************************************
app.config(['$routeProvider', function($routeProvider){
    $routeProvider
      .when('/song-list/1981', {
        templateUrl: 'music-list',
        controller: 'SongListController'
      })
      .otherwise({
        redirectTo: '/'
      });
  }])
//  Service
//****************************************
.factory('SongListService', ['$http', '$q', function ($http, $q) {
  var factory = {
  
  };
  return factory;
}])
//  Controller
//****************************************
.controller('SongListController', ['$scope', 'SongListService', function ($scope, SongListService) {

}]);