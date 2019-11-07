vcl 4.0;


backend default {
    .host = "credit-sales-funnel";
    .port = "9000";
}

backend scoring {
    .host = "scoring";
    .port = "9001";
}

sub vcl_recv {
    if (req.url ~ "^/scoring") {
       set req.backend_hint = scoring;
    } else if (req.url ~ "^/application") {
            set req.backend_hint = default;
            return(pass);
    } else {
       set req.backend_hint = default;
    }
}

sub vcl_backend_response {
    set beresp.do_esi = true;
}