(function() {

  'use strict';

  angular
    .module('myApp')
    .controller('paymentController', paymentController);

    paymentController.$inject = ['$rootScope', '$scope'];

    function paymentController($rootScope, $scope) {
      //    if (SqPaymentForm.isSupportedBrowser()) {
		    //   paymentForm.build();
		    //   paymentForm.recalculateSize();
		    // }
		    paymentForm.build();
      paymentForm.recalculateSize();
    }

})();

