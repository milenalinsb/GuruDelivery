import client from "./client";

export async function postUser(user){
    return client.post("/usuarios", user)
}

export async function login(username, password){
    const resp = await client.post("/login",{}, {
        auth:{
            username: username,
            password: password
        }
    })
    if(resp.data){
        localStorage.setItem('user', JSON.stringify(resp.data))
        localStorage.setItem('token', btoa(`${username}:${password}`))
    }
    return resp.data
}

export async function getEnderecos(){
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const resp = await client.get(`/usuarios/${userId}/enderecos`)
    return resp.data
}

export async function getUserPedidos(){
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const resp = await client.get(`/usuarios/${userId}/pedidos`)
    return resp.data
}
