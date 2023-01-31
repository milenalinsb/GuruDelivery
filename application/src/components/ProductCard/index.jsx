import React, { useState } from 'react'
import Counter from '../Counter'
import Separator from '../Separator'

export default function ProductCard() {

    const [counter, setCounter] = useState(0)

  return (
    <div class="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
    <a href="#">
        <img class="rounded-t-lg" src="https://bobs.com.br/media/filer_public_thumbnails/filer_public/1f/61/1f61237f-ecaa-4cca-a3ce-c770d5974560/new_v4-bobs-burger-celeb.png__1200x630_subsampling-2_upscale.png" alt="" />
    </a>
    <div class="p-5">
        <a href="#">
            <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">Name</h5>
        </a>
        <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">desc</p>
        <p className='text-primary font-bold'>R$ XX,xx</p>
        <div className='flex gap-2'>
            <Counter value={counter} onChange={setCounter}/>
            <button className='text-on-primary bg-primary rounded-md px-2'>Adicionar</button>
        </div>
        
    </div>
</div>
  )
}
