'use strict';
var app = angular.module('MusicServer', ['ngRoute', 'ngSanitize']);
//  Service
//****************************************
app.factory('SongListService', ['$http', '$q', function ($http, $q) {
	
  var factory = {
    init:init  
  };
  return factory;
  
  function init(scope) {
    $http.get("/search-music-list" + scope.year, null).then(function(response) {
      scope.data = response.data;
    }, function(response) {
      console.log('ERROR:' + response.data);
    });
  }

}])
//  Controller
//****************************************
.controller('SongListController', ['$scope', 'SongListService', function ($scope, SongListService) {

  $scope.year = 2000;
  
  SongListService.init($scope);
  
  $scope.changeYears = function(){
	  console.log('changeYears');
  };
  
  //$('.nav-link').removeClass("active");
  
}])
//  Route Config
//****************************************
.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
  .when('/song-list/1980', {templateUrl: 'music-list', controller: 'SongListController'})
  .when('/song-list/1981', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1982', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1983', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1984', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1985', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1986', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1987', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1988', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1989', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1990', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1991', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1992', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1993', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1994', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1995', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1996', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1997', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1998', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1999', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2000', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2001', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2002', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2003', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2004', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2005', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2006', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2007', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2008', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2009', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2010', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2011', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2012', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2013', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2014', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/2015', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).otherwise({
    redirectTo: '/'
  });
}]);

audiojs.events.ready(function() {
    var as = audiojs.createAll();
});