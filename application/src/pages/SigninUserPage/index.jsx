import React from 'react'
import styles from './SigninUserPage.module.css'
import loginStyles from '../LoginPage/LoginPage.module.css'
import Separator from '../../components/Separator'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import { Field, Form, Formik } from 'formik'

export default function SigninUserPage() {

    function onSubmit(values){
        alert(JSON.stringify(values))
    }

  return (
    <div className='container'>
        <div className={styles.signinContainer}>

            <div className={loginStyles.header}>
                <div className={loginStyles.headerLogo}>
                    Guru Delivery
                </div>
                <div className={loginStyles.headerText}>
                    Preencha os campos para criar o seu cadastro.
                </div>
                <Separator/>
            </div>
            <div className={loginStyles.form}>
                <Formik
                    initialValues={{nome: "", email: "", password: ""}}
                    onSubmit={onSubmit}
                >
                    {(

                    )=>(    
                        <Form>
                            <Field as={InputText} name="nome" type="text" placeholder="Digite seu nome"/>
                            <Field as={InputText} name="email" type="email" placeholder="Digite seu e-mail"/>
                            <Field as={InputText} name="password" type="password" placeholder="Digite sua senha"/>
                            <LargeButton text="Cadastrar" bg/>
                            <Separator/>
                        </Form>
                    )}
                </Formik>
            </div>
            <div className={styles.footer}>
                Já tem cadastro? <a href='#'>Fazer Login</a>
            </div>

        </div>
    </div>
  )
}
