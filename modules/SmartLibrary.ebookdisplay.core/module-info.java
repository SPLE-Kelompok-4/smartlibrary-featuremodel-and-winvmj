module SmartLibrary.ebookdisplay.core {
    exports SmartLibrary.ebookdisplay;
    exports SmartLibrary.ebookdisplay.core;
    exports SmartLibrary.ebookdisplay.core.model;
    exports SmartLibrary.ebookdisplay.core.service;
    exports SmartLibrary.ebookdisplay.core.resource;
    
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    requires vmj.auth;
    requires vmj.auth.model;  
    requires prices.auth.vmj;
    requires java.logging;
    requires java.naming;
    requires java.net.http;
    requires java.persistence; 
    requires java.sql;        
    requires java.desktop;     
    
    opens SmartLibrary.ebookdisplay.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
    opens SmartLibrary.ebookdisplay.core.model to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
    opens SmartLibrary.ebookdisplay.core.service to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
    opens SmartLibrary.ebookdisplay.core.resource to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}