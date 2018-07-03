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
    $http.get("/song-list-1980", null).then(function(response) {
      scope.data = response.data;
      console.log(response.data);
    }, function(response) {
      console.log('ERROR:' + response.data);
    });
  }
  
//	$http.post('/batch/ExamineesTicketJob', executionParameter, headers).then(function(response) {
//	  console.log(response.data);
//	  $('#loading').addClass('hide');
//	}, function(response) {
//	  console.log('ERROR:'+response.data);
//	  $('#loading').addClass('hide');
//	});
  
}])
//  Controller
//****************************************
.controller('SongListController', ['$scope', 'SongListService', function ($scope, SongListService) {
	
  SongListService.init($scope);
  
  $scope.year = 1980;
  
  $scope.years = [ 
	  {key:1980,value:"1980年"}, {key:1981,value:"1981年"}, {key:1982,value:"1982年"}, {key:1983,value:"1983年"}, {key:1984,value:"1984年"}, {key:1985,value:"1985年"}, 
	  {key:1986,value:"1986年"}, {key:1987,value:"1987年"}, {key:1988,value:"1988年"}, {key:1989,value:"1989年"}, {key:1990,value:"1990年"}, {key:1991,value:"1991年"}, 
	  {key:1992,value:"1992年"}, {key:1993,value:"1993年"}, {key:1994,value:"1994年"}, {key:1995,value:"1995年"}, {key:1996,value:"1996年"}, {key:1997,value:"1997年"}, 
	  {key:1998,value:"1998年"}, {key:1999,value:"1999年"}, {key:2000,value:"2000年"}, {key:2001,value:"2001年"}, {key:2002,value:"2002年"}, {key:2003,value:"2003年"}, 
	  {key:2004,value:"2004年"}, {key:2005,value:"2005年"}, {key:2006,value:"2006年"}, {key:2007,value:"2007年"}, {key:2008,value:"2008年"}, {key:2009,value:"2009年"}, 
	  {key:2010,value:"2010年"}, {key:2011,value:"2011年"}, {key:2012,value:"2012年"}, {key:2013,value:"2013年"}, {key:2014,value:"2014年"}, {key:2015,value:"2015年"} ];
  
  
  $scope.changeYears = function(){
	  console.log('changeYears');
  };
  
  $('.nav-link').removeClass("active");

}])
//  Route Config
//****************************************
.config(['$routeProvider', function ($routeProvider) {
  $routeProvider.when('/song-list/1980', {
    templateUrl: 'music-list',
    controller: 'SongListController'
  }).when('/song-list/1981', {
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