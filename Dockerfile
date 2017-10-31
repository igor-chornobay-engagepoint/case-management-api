FROM cwds/javajdk
RUN mkdir /opt/case-management-api
RUN mkdir /opt/case-management-api/logs
ADD config/*.yml /opt/case-management-api/
ADD config/shiro.ini /opt/case-management-api/config/shiro.ini
ADD build/libs/case-management-api-dist.jar /opt/case-management-api/case-management-api.jar
ADD build/entrypoint.sh /opt/case-management-api/
EXPOSE 8080 
RUN chmod +x /opt/case-management-api/entrypoint.sh
WORKDIR /opt/case-management-api
CMD ["/opt/case-management-api/entrypoint.sh"]