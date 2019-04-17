//package xyz.kingsword.gateway.config;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class JsonConfig implements WebMvcConfigurer {
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    }
//
//    public ObjectMapper getObjectMapper() {
//        return new ObjectMapper();
//    }
//
//
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        /*1  预先定义一个Converters 转换消息的对象
//         * 2 添加fastjson的配置信息
//         * 3 早converter中添加配置信息
//         * 4.将converter添加到converters中
//         */
//        //super.configureMessageConverters(converters);//
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        List<MediaType> supportedMediaTypes = new ArrayList<>(20);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//
//        //创建配置类
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteMapNullValue
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        //将fastJson添加到视图消息转换器列表内
//        converters.add(fastConverter);
//    }
//}