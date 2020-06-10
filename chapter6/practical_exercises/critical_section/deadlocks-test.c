#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
int a = 0, b = 0;
pthread_mutex_t lock_a, lock_b;
void *fun_1(void *arg)
{
  int i;
  for (i = 0; i < 10000; i++)
  {
    pthread_mutex_lock(&lock_a); //lock a then b
    pthread_mutex_lock(&lock_b); //CRITICAL SECTION
    a++;
    b++;
    pthread_mutex_unlock(&lock_a);
    pthread_mutex_unlock(&lock_b);
  }
  return NULL;
}
void *fun_2(void *arg)
{
  int i;
  for (i = 0; i < 10000; i++)
  {
    pthread_mutex_lock(&lock_b); //lock b then a
    pthread_mutex_lock(&lock_a); //CRITICAL SECTION
    a++;
    b++;
    pthread_mutex_unlock(&lock_b);
    pthread_mutex_unlock(&lock_a);
  }
  return NULL;
}
int main()
{
  pthread_t thread_1, thread_2;
  pthread_mutex_init(&lock_a, NULL);
  pthread_mutex_init(&lock_b, NULL);
  pthread_create(&thread_1, NULL, fun_1, NULL);
  pthread_create(&thread_2, NULL, fun_2, NULL);
  pthread_join(thread_1, NULL);
  pthread_join(thread_2, NULL);
  printf("\ta=%db=%d \n", a, b);
  return 0;
}