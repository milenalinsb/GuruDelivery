import React from 'react'

export default function HeaderCard() {
  return (
    <>
        <a href="#" class="flex flex-col items-center bg-primary border border-gray-200 rounded-lg 
        shadow md:flex-row w-full hover:bg-gray-100 text-on-primary
         dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700">
            <img class="object-cover w-full rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-l-lg" src="https://i.pinimg.com/originals/e7/92/7e/e7927ea0f21bd2210c2506d5b569f131.jpg" alt=""/>
            <div class="flex flex-col justify-between p-4 leading-normal">
            <h5 class="mb-2 text-2xl font-bold tracking-tights dark:text-white">Name</h5>
        <p class="mb-3 font-normal ">info: valeue</p>
    </div>
</a>
    </>
  )
}
