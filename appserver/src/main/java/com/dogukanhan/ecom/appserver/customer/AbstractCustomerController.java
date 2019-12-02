package com.dogukanhan.ecom.appserver.customer;

import com.dogukanhan.ecom.appserver.entity.Bucket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public abstract class AbstractCustomerController {

    @ModelAttribute("bucket")
    public Bucket bucket(HttpServletRequest request) {
        Object b1 = request.getSession().getAttribute("bucket");
        if (b1 == null) {
            Bucket bucket = new Bucket();
            bucket.setProducts(List.of());
            request.getSession().setAttribute("bucket", bucket);
            return bucket;
        }
        return (Bucket) b1;
    }

}
