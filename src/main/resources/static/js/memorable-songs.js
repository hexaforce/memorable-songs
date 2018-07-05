'use strict';
var app = angular.module('MusicServer', ['ngRoute', 'ngSanitize']);

//  Service
//****************************************
app.factory('SongListService', ['$http', '$q', function ($http, $q) {
	
  var factory = {
    init:init,
    search:search
  };
  return factory;

  function init(scope) {
    $http.get("/search-music-list/" + scope.year, null).then(function(response) {
      scope.data = response.data;
    }, function(response) {
      console.log('ERROR:' + response.data);
    });
  }

  function search(scope) {
	var request = new Object();
	request["searchWord"] = scope.searchWord;
    $http.post("/search-music-list", request, null).then(function(response) {
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
  $scope.searchWord = "";
  
  SongListService.init($scope);
  
  $scope.changeYears = function(){
	  console.log('changeYears');
  };
  
  //$('.nav-link').removeClass("active");
  
}])
//  Controller
//****************************************
.controller('SearchController', ['$scope', 'SongListService', function ($scope, SongListService) {

  $scope.searchWord = "";

  $scope.search = function search() {
	  SongListService.search($scope);
  };
  
}])
//  Route Config
//****************************************
.config(['$routeProvider', function ($routeProvider) {
  var x = {templateUrl: 'music-list', controller: 'SongListController'};
  for (var i = 1980; i < 2016; i++) 
    $routeProvider.when('/search-music-list/' + i, x);
  $routeProvider.otherwise({redirectTo: '/'});
}]);

// audiojs
//****************************************
audiojs.events.ready(function() {
    var as = audiojs.createAll();
});
function onclick(e) {
	  console.log(e);
};