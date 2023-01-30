import React from 'react'
import Separator from '../../components/Separator'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import { Field, Form, Formik } from 'formik'

export default function SigninUserPage() {

    function onSubmit(values){
        alert(JSON.stringify(values))
    }

  return (
    <div className='h-screen flex flex-col justify-center items-center bg-background 
    font-sans'>
            <div className='w-full bg-surface drop-shadow p-5 rounded-lg max-w-md'>
                <div className='text-primary text-4xl text-center my-8'>
                    Guru Delivery
                </div>
                <div className='text-center text-base font-sans'>
                    Preencha os campos para criar o seu cadastro.
                </div>
                <Separator />
                <div className=''>
                <Formik
                    initialValues={{nome: "", email: "", password: ""}}
                    onSubmit={onSubmit}
                >
                    {(

                    )=>(    
                        <Form className='flex flex-col'>
                            <Field as={InputText} name="nome" type="text" placeholder="Digite seu nome"/>
                            <Field as={InputText} name="email" type="email" placeholder="Digite seu e-mail"/>
                            <Field as={InputText} name="password" type="password" placeholder="Digite sua senha"/>
                            <div className='mt-10'/>
                            <LargeButton text="Cadastrar" bg/>
                            <Separator/>
                        </Form>
                    )}
                </Formik>
            </div>
            <div className='text-center text-sm'>
                Já tem cadastro? <a className='text-primary' href='#'>Fazer Login</a>
            </div>
        </div>
    </div>
  )
}
