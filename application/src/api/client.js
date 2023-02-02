import axios from 'axios'

const client = axios.create({
    baseURL: 'http://localhost:8080'
  });

client.interceptors.request.use((config)=>{
    if(localStorage.getItem("token")){
        config.headers.Authorization = "BASIC "+localStorage.getItem("token")
        console.dir(config.headers)
    }
    return config
})

export default client