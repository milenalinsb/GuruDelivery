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
        localStorage.setItem('user', resp.data)
        localStorage.setItem('token', btoa(`${username}:${password}`))
    }
    return resp.data
}
