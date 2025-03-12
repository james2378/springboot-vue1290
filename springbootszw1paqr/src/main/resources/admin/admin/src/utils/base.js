const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootszw1paqr/",
            name: "springbootszw1paqr",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootszw1paqr/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于web的车票管理系统的设计与实现"
        } 
    }
}
export default base
