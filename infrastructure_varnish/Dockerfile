FROM ubuntu:14.04
RUN apt-get update && apt-get dist-upgrade -y -qq
RUN apt-get install -y -qq apt-transport-https
RUN apt-get install -y -qq curl && \
curl -L https://packagecloud.io/varnishcache/varnish41/gpgkey | sudo apt-key add - && \
echo "deb https://packagecloud.io/varnishcache/varnish41/ubuntu/ trusty main" \
>> /etc/apt/sources.list.d/varnishcache_varnish41.list && \
echo "deb-src https://packagecloud.io/varnishcache/varnish41/ubuntu/ trusty main" \
>> /etc/apt/sources.list.d/varnishcache_varnish41.list
RUN apt-get update
RUN apt-get install -y -qq varnish
COPY default.vcl /etc/varnish/default.vcl
COPY start /start
RUN chmod 0755 /start
CMD ["/start"]