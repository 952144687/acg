package com.acg.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class OutAnimeImage extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\anime_img\\");
        registry.addResourceHandler("/postImg/**").addResourceLocations("file:D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\post_img\\");
        registry.addResourceHandler("/pic/**").addResourceLocations("file:D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\pic\\");
        registry.addResourceHandler("/userAvatar/**").addResourceLocations("file:D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\user_avatar\\");
        super.addResourceHandlers(registry);
    }
}
