module SmartLibrary.wishlistmanagement.core {
	requires SmartLibrary.wishlistmanagement.core;
	exports SmartLibrary.wishlistmanagement;
    exports SmartLibrary.wishlistmanagement.core;
	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires vmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens SmartLibrary.wishlistmanagement.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
