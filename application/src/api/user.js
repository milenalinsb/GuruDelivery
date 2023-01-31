import client from "./client";

export async function postUser(user){
    return client.post("/usuarios", user)
}