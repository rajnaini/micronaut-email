java -cp build/libs/complete-0.1-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer

/home/rajnaini/tools/graalvm-ce-1.0.0-rc15/bin/native-image --no-server \
             --class-path build/libs/complete-0.1-all.jar \
             -H:ReflectionConfigurationFiles=build/reflect.json,./netty_reflection_config.json \
             -H:EnableURLProtocols=http \
             -H:IncludeResources='logback.xml|application.yml|META-INF/services/*.*|templates/*.*|com/amazonaws/partitions/*.*' \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+AllowVMInspection \
             --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder',javax.net.ssl.SSLContext,com.amazonaws.http.conn.ClientConnectionManagerFactory \
             --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,io.netty.handler.ssl.ReferenceCountedOpenSslEngine,io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator,io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,io.netty.handler.ssl.ConscryptAlpnSslEngine,io.netty.handler.ssl.JettyNpnSslEngine \
             -H:-UseServiceLoaderFeature \
             --allow-incomplete-classpath \
             -H:Name=micronaut-email \
             -H:+ReportExceptionStackTraces \
             --enable-https \
             --enable-all-security-services \
             -H:Class=example.micronaut.Application
