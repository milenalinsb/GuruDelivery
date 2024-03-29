import { Field, Form, Formik } from 'formik'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { postEmpresa } from '../../api/empresa'
import InputText from '../../components/InputText'
import LargeButton from '../../components/LargeButton'
import Separator from '../../components/Separator'

export default function SigninCompPage() {

    const navigate = useNavigate();
    const [file, setFile] = useState({})

    async function onSubmit(values, helpers){
        const reqData = {
            nome: values.nome,
            cnpj: values.CNPJ,
            email: values.email,
            senha: values.senha,
            fotoPerfil: values.foto,
            telefone: values.tel,
            cep: values.cep,
            cidade: values.cidade,
            bairro: values.bairro,
            rua: values.rua,
            numero: values.num,
            complemento: values.complemento,

        }
        const formData = new FormData()
        formData.append('nome', reqData.nome)
        formData.append('cnpj', reqData.cnpj)
        formData.append('email', reqData.email)
        formData.append('senha', reqData.senha)
        formData.append('telefone', reqData.telefone)
        formData.append('cep', reqData.cep)
        formData.append('cidade', reqData.cidade)
        formData.append('bairro', reqData.bairro)
        formData.append('rua', reqData.rua)
        formData.append('numero', reqData.numero)
        formData.append('complemento', reqData.complemento)
        formData.append('fotoPerfil', file)
        console.dir(file)
        try{
            const data = await postEmpresa(formData)
            //helpers.resetForm()
            alert("Cadastrado com sucesso")
            navigate("/login")
        }catch(err){
            console.dir(err)
        }
    }

    const initialValues= {
        foto: '',
        CNPJ: '',
        nome: '',
        tel:'',
        email: '',
        rua:'',
        num:'',
        cep:'',
        bairro:'',
        cidade:'',
        estado:'',
        complemento:'',
        senha: ''
    }

  return (
    <>
        <div className='h-screen flex flex-col items-center center
          justify-center bg-background font-sans p-2'>
            <div className='w-full bg-surface drop-shadow p-5 rounded-lg max-w-4xl'>
                
                <div className='text-primary text-4xl text-center my-8'>
                    Guru Delivery
                </div>
                <div className='text-center text-base font-sans'>
                    Preencha os campos para criar o seu cadastro.
                </div>
                <Separator/>

                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                >
                    {({
                        setFieldValue, values
                    })=>(
                        <Form className='flex flex-col flex-1 gap-5'>
                            <input type='file' className='basis-1/2' name='foto' onChange={(event) => {
                                setFile(event.currentTarget.files[0])}}
                            />
                            <div className='flex gap-3'>
                                <Field className='basis-1/3' as={InputText} name='CNPJ' type="text" placeholder='Digite o CNPJ'/>
                                <Field className='basis-2/3' as={InputText} name='nome' type="text" placeholder='Digite o nome'/>
                            </div>
                            <div className='flex gap-3'>
                                <Field className='basis-1/3' as={InputText} name='tel' type='text' placeholder='Digite o telefone'/>
                                <Field as={InputText} className='basis-2/3' name='email' type='email' placeholder='Digite o e-mail'/>
                            </div>
                            <div className='flex gap-3'>
                                <Field as={InputText} name='senha' type='password' placeholder='Digite a senha'/>
                            </div>
                            <div className='flex gap-3'>
                                <Field as={InputText} name='rua' type='text' placeholder='Digite o nome da rua'/>
                            </div>
                            <div className='flex gap-3'>
                                <Field as={InputText} name='num' type='number' placeholder='Numero'/>
                                <Field as={InputText} name='cep' type='text' placeholder='CEP'/>
                                <Field as={InputText} name='bairro' type='text' placeholder='Bairro'/>
                                <Field as={InputText} name='cidade' type='text' placeholder='Cidade'/>
                            </div>
                            <div className='flex gap-3'>
                                <Field as={InputText} name='estado' type='text' placeholder='Estado'/>
                                <Field as={InputText} name='complemento' type='text' placeholder='Complemento'/>
                            </div>
                            <LargeButton text='Cadastrar' bg/>
                        </Form>
                    )}
                </Formik>
                <Separator/>
                <div className='text-center text-sm'>
                    Já tem cadastro? <Link className='text-primary' to="/login">Fazer Login</Link>
                </div>
            </div>
        </div>
    </>
  )
}
