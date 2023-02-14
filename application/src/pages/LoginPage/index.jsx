import { Field, Form, Formik } from 'formik'
import React, {useContext, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import Separator from '../../components/Separator'
import {login} from "../../api/user";
import ErrorMessage from "../../components/ErrorMessage";
import AuthContext from '../../context/AuthContext'

export default function LoginPage() {
  const navigate = useNavigate()
  const [loginError, setLoginError] = useState("");
  const auth = useContext(AuthContext)

  async function onSubmit(values){
    try{
      const user = await login(values.email, values.password)
      setLoginError("")
      auth.user = user
      navigate("/home")
    }catch (err){
      console.dir(err)
      if(err.response.status === 401){
        setLoginError("Usuário ou Senha incorretos")
      }
    }
  }

  return (
    <>
      <div className='h-screen flex flex-col items-center center
          justify-center bg-background font-sans'>
          <div className='w-full bg-surface drop-shadow p-5 rounded-lg max-w-md'>
            <div className='text-primary text-4xl text-center my-8'>
              Guru Delivery
            </div>
            <div className='text-center text-md font-sans'>
              Use suas credenciais para realizar o login.
            </div>
            <Separator />

            <div className='flex flex-col'>
              {loginError!==""?(<ErrorMessage message={loginError}/> ):""}
              <Formik
                initialValues={{email: "", password: ""}}
                onSubmit={onSubmit}
              >
              {({
                values,
                errors,
                handleChange
              }) => (
                <Form className='flex flex-col'>
                  <Field as={InputText} name="email" type="email" placeholder="Digite o seu email"/>
                  <Field as={InputText} name="password" type="password" placeholder='Digite sua senha'/>
                  <div className='flex flex-col mt-10'>
                    <LargeButton text="Enviar" bg/>
                  </div>
                  <Separator />
                </Form>
            )}
            </Formik>
            <LargeButton text="Quero me Cadastrar" action={()=> navigate("/signin-usr")}/>
          </div>

        </div>
      </div>
    </>
  )
}
